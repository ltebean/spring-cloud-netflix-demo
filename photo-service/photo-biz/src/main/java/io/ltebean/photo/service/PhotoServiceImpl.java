package io.ltebean.photo.service;

import io.ltebean.photo.api.PhotoService;
import io.ltebean.photo.dto.PhotoDTO;
import io.ltebean.photo.mapper.PhotoMapper;
import io.ltebean.photo.model.Photo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ltebean on 16/4/1.
 */

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoMapper photoMapper;

    @Override
    public PhotoDTO getPhoto() {
        Photo photo = photoMapper.selectById(1);
        return new PhotoDTO();
    }
}
