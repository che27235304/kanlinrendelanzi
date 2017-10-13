package com.example.mvprxjava2degger2retrofit2.bean;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by KING on 2017/9/21 16:36
 * 邮箱:992767879@qq.com
 */
@Entity
public class Shujukulei {
        @Id(autoincrement = true)
        private Long id;
        @Property(nameInDb = "name")
        private String name;
        @Property(nameInDb = "esx")
        private String esx;
        @Property(nameInDb = "age")
        private int age;
        @Generated(hash = 1429555337)
        public Shujukulei(Long id, String name, String esx, int age) {
            this.id = id;
            this.name = name;
            this.esx = esx;
            this.age = age;
        }
        @Generated(hash = 1023519989)
        public Shujukulei() {
        }
        public Long getId() {
            return this.id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getName() {
            return this.name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEsx() {
            return this.esx;
        }
        public void setEsx(String esx) {
            this.esx = esx;
        }
        public int getAge() {
            return this.age;
        }
        public void setAge(int age) {
            this.age = age;
        }
}
