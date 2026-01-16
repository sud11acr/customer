package com.project.bank.customer.proxy;

import com.project.bank.customer.domain.proxy.product.ProductResponse;
import io.reactivex.Observable;
import retrofit2.http.POST;

public interface ProductProxy {
    @POST("/v1/api/products")
    Observable<ProductResponse> createProduct();
}
