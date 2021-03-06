package ua.ita.smartcarservice.dto.files;

import lombok.Data;
import ua.ita.smartcarservice.entity.UserEntity;


@Data
public class AvatarDto {

    private UserEntity userId;
    private String username;
    private String filePath;
    private String fileName;

    public AvatarDto(UserEntity userId, String username, String filePath, String fileName) {
        this.userId = userId;
        this.username = username;
        this.filePath = filePath;
        this.fileName = fileName;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
