package com.example.data.repository.dataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.api.ArtObjectAPIService
import com.example.data.model.headline.ArtObject
import com.example.data.model.query.ArtObjectHeadlinesQueryImpl
import com.example.domain.model.query.ArtObjectHeadlinesQuery
import retrofit2.HttpException
import java.io.IOException

class ArtObjectPagingSource(
    private val defaultArtObjectHeadlinesQueryImpl: ArtObjectHeadlinesQueryImpl,
    private val artObjectAPIService: ArtObjectAPIService,
    ): PagingSource<ArtObjectHeadlinesQueryImpl, ArtObject>() {

    override suspend fun load(params: LoadParams<ArtObjectHeadlinesQueryImpl>): LoadResult<ArtObjectHeadlinesQueryImpl, ArtObject> {

        val artObjectHeadlinesQueryImpl = params.key ?: defaultArtObjectHeadlinesQueryImpl

        return try {
            artObjectHeadlinesQueryImpl.let {
                val response = artObjectAPIService.getArtObjects(language = it.language, pageRange = it.pageRange, page = it.page)
                val repos = response.body()?.artObjects as List<ArtObject>
                val nextKey = if (repos.isEmpty()) null else ArtObjectHeadlinesQueryImpl(it.language , it.pageRange  , it.page + 1)

                LoadResult.Page(
                    data = repos,
                    prevKey = if (it.page == defaultArtObjectHeadlinesQueryImpl.page) null else ArtObjectHeadlinesQueryImpl(it.language , it.pageRange , it.page - 1),
                    nextKey = nextKey)
            }

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }

    }

    override fun getRefreshKey(state: PagingState<ArtObjectHeadlinesQueryImpl, ArtObject>): ArtObjectHeadlinesQueryImpl? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.let {
                if (it.prevKey != null){
                    ArtObjectHeadlinesQueryImpl(it.prevKey!!.language, it.prevKey!!.pageRange, it.prevKey!!.page.plus(1))
                }else if (it.nextKey != null){
                    ArtObjectHeadlinesQueryImpl(it.nextKey!!.language , it.nextKey!!.pageRange, it.nextKey!!.page.minus(1))
                } else{
                    defaultArtObjectHeadlinesQueryImpl
                }
            }
        }
    }
}