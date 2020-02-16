package com.example.application2;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BloggerApi {
    private static final String key="7pxze";
    private static final  String URL="https://api.myjson.com/bins/";
    public static PostService postService=null;
    public static PostService getPostService(){
        if(postService==null)

        {
          //  Retrofit retrofit = new Retrofit().Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
            Retrofit retrofit=new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
            postService=retrofit.create(PostService.class);
    }
    return postService;
    }
    public interface PostService{
        @GET("?Key="+key)
        Call<PostList>getpostlist();
    }
}
