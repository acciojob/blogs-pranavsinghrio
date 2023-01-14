package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    ImageRepository imageRepository2;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog
//        Image image = new Image();
//        image.setDimensions(dimensions);
//        image.setDescription(description);
//        List<Image> imageList = blog.getImageList();
//        imageList.add(image);
//        blog.setImageList(imageList);
//        image.setBlog(blog);
//        imageRepository2.save(image);
//        blogRepository.save(blog);
//        return image;
        Image image = new Image(description,dimensions);
        image.setBlog(blog);
       return image;
    }

    public void deleteImage(Image image){
        imageRepository2.delete(image);
    }

    public Image findById(int id)
    {
        return imageRepository2.findById(id).get();
    }

    public int countImagesInScreen(Image image, String screenDimensions) {

//        if (image == null) {
//            return 0;
//        }
//        String[] imageDimensions = image.getDimensions().split("X");
//        int imageWidth = Integer.parseInt(imageDimensions[0]);
//        int imageHeight = Integer.parseInt(imageDimensions[1]);
//        String[] screenDim = screenDimensions.split("X");
//        int screenWidth = Integer.parseInt(screenDim[0]);
//        int screenHeight = Integer.parseInt(screenDim[1]);
//        int screenArea = screenWidth * screenHeight;
//
//        int imageArea = imageWidth * imageHeight;
//
//        return screenArea / imageArea;
//    }
        if (screenDimensions.split("X").length == 2 || Objects.nonNull(image)) {
            Integer maxLength = Integer.parseInt(screenDimensions.split("X")[0]) / Integer.parseInt(image.getDimensions().split("X")[0]);
            Integer maxWidth = Integer.parseInt(screenDimensions.split("X")[1]) / Integer.parseInt(image.getDimensions().split("X")[1]);

            return maxWidth * maxLength;
        }
        return 0;
    }
}