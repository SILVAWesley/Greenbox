package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Iaron-PC on 19/07/2016.
 */
public class UserDirectory {

    private UUID uuid;
    private List<File> files;
    private UserDirectory parent;
    private List<UserDirectory> children;
    private String name;

    public UserDirectory(String name, UserDirectory parent){
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.parent = parent;
        this.files = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    // This constructor should be used only when a new User is created
    public UserDirectory(String name){
        this(name, null);
    }

    public void addFile(String filename, StringBuffer fileContent) throws Exception{
        File file = new File(this.name + "/" + filename + ".txt"); // we should create an enum later for the file types.
        writeInFile(file, fileContent);
        this.files.add(file);
    }

    public void addDirectory(String directoryName){
        UserDirectory dir = new UserDirectory(this.name + "/" + directoryName, this);
        this.children.add(dir);
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

    private void writeInFile(File file, StringBuffer fileContent) throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter(file)); // This throws an exception.
        writer.write(fileContent.toString());
        writer.close();
    }



    //Getters

    public UUID getUuid(){
        return this.uuid;
    }

    public List<File> getFiles() {
        return files;
    }

    public List<UserDirectory> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public UserDirectory getParent() {
        return parent;
    }
}
