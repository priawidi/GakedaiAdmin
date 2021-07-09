package com.mobcom.gakedaiadmin.api;

import com.google.gson.JsonObject;
import com.mobcom.gakedaiadmin.model.GetMenuModel;
import com.mobcom.gakedaiadmin.model.PostPutDelMenu;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ApiEndpoint {
    @GET("menu")
    Call<GetMenuModel> getMenu();
    @FormUrlEncoded
    //@Headers("X-CSRF-TOKEN: 2wyZkj2rxxnwr7TToti2oBRZHBkIECYZk2uulDOh")
    @POST("menu")
    Call<PostPutDelMenu> putMenu(@Field("id") String id,
                                 @Field("name") String name,
                                 @Field("code") String code,
                                 @Field("type") String type,
                                 @Field("price") String price,
                                 @Field("photo") String photo,
                                 @Field("detail") String detail,
                                 @Field("status") String status
                                 );
    //Call<PostPutDelMenu> putMenu(@Body PostPutDelMenu menu_object);
    @FormUrlEncoded
    //@Headers("X-CSRF-TOKEN: 2wyZkj2rxxnwr7TToti2oBRZHBkIECYZk2uulDOh")
    @PUT("menu/{id}")
    Call<PostPutDelMenu> updateMenu(@Path("id") String id,
                                    @Field("name") String name,
                                    @Field("code") String code,
                                    @Field("type") String type,
                                    @Field("price") String price,
                                    @Field("photo") String photo,
                                    @Field("detail") String detail,
                                    @Field("status") String status
    );
    @FormUrlEncoded
    @PUT("menu")
    @HTTP(method = "DELETE", path = "menu", hasBody = true)
    Call<PostPutDelMenu>deleteMenu(@Field("id") String id);

}
