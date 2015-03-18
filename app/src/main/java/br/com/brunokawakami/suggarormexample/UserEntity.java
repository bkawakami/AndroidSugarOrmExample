package br.com.brunokawakami.suggarormexample;

import com.orm.SugarRecord;

/**
 * Created by bruno on 18/03/15.
 */
public class UserEntity extends SugarRecord<UserEntity> {
    String name;
    String email;

    public UserEntity(){
    }

    public UserEntity(String name, String email){
        this.name = name;
        this.email = email;
    }
}
