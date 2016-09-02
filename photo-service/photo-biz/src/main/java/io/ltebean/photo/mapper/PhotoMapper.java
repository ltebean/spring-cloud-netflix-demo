package io.ltebean.photo.mapper;

import io.ltebean.photo.model.Photo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by leo on 16/7/28.
 */
@Mapper
public interface PhotoMapper {

    public Photo selectById(@Param("photoId") long photoId);

}
