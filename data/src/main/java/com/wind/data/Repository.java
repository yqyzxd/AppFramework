package com.wind.data;

import com.wind.base.request.BaseRequest;
import com.wind.base.response.BaseResponse;

import rx.Observable;

/**
 * Created by wind on 16/5/19.
 */
public interface Repository<Q extends BaseRequest,R extends BaseResponse> {
   Observable<R> get(Q request);
}
