package com.micheal.dts.service;

import com.micheal.dts.component.dao.PackageDao;
import com.micheal.dts.io.RespCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.jar.JarFile;

@Service
public class PackageService {
    @Autowired
    PackageDao packageDao;
    public RespCode upload(String schedName, MultipartFile file) {
        //解析该jar里面的内容,遍历该jar包中的类文件，找出job的实现类；
        try {
            JarFile jarFile = new JarFile(file.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }

        //
        return null;
    }

    public List<String> classNameQuery(String schedName) {
        List<String> data = packageDao.classNameQuery(schedName);
        return data;
    }
}
