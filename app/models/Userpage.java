package models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Iaron-PC on 17/07/2016.
 */
public class Userpage {

    private UUID uuid;
    private List<File> userfiles;

    public Userpage(){
        this.uuid = UUID.randomUUID();
        this.userfiles = new ArrayList<>();
    }

    public List<File> getUserfiles(){
        return this.userfiles;
    }

    public void addFile(File file) throws Exception{
        if(!file.isFile()) throw new Exception("Not a file!");
        if(!isValidFileType(file)) throw new Exception("Not a valid file type!");
        this.userfiles.add(file);
    }

    public void addDirectory(File directory) throws Exception{
        if(!directory.isDirectory()) throw new Exception("Not a directory!");
        this.userfiles.add(directory);
    }

    public UUID getUuid() {
        return uuid;
    }

    private boolean isValidFileType(File file){
        String fileName = file.getName();
        String[] nameDivisions = fileName.split(".");
        String fileType = nameDivisions[nameDivisions.length -1];

        // To add more valid types, we just need to put an AND
        if(fileType.equals("txt")){
            return true;
        } else {
            return false;
        }
    }



}
