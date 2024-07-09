package co.edu.uniquindio.proyecto.impl;

import co.edu.uniquindio.proyecto.servicios.ImagenesServicio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

public class ImagenServicioImpl implements ImagenesServicio {

    private Cloudinary cloudinary;

    public ImagenServicioImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public void ImagenesServicioImpl(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dqkoltbf0");
        config.put("api_key", "818749439566557");
        config.put("api_secret", "TNNvJ8q4fXP9WWGX0bN0J_gnvvA");
        cloudinary = new Cloudinary(config);
    }

    @Override
    public Map subirImagen(MultipartFile imagen) throws Exception {
        File file = convertir(imagen);
        return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", "unilocal"));
    }
    @Override
    public Map eliminarImagen(String idImagen) throws Exception {
        return cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
    }
    private File convertir(MultipartFile imagen) throws IOException {
        File file = File.createTempFile(imagen.getOriginalFilename(), null);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagen.getBytes());
        fos.close();
        return file;
    }
}

