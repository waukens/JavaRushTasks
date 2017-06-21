package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("tmp", ".txt", new File("C:/Intel/"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User tempUser = new User();
            tempUser.setFirstName("Andry");
            tempUser.setBirthDate(new Date());
            tempUser.setCountry(User.Country.RUSSIA);

            javaRush.users.add(tempUser);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            if (javaRush.equals(loadedObject))
                System.out.println("yes");
            else
                System.out.println("false");
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            for (User user : users) {
                pw.println(user.getFirstName());
                pw.println(user.getLastName());
                if (!user.getBirthDate().equals(null)) {
                    pw.println(user.getBirthDate().getTime());
                } else {
                    pw.println("null");
                }
                pw.println(user.getCountry());
                pw.println(user.isMale());
                pw.flush();
            }


        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while (br.ready()) {
                User tempUser = new User();
                tempUser.setFirstName(br.readLine());
                tempUser.setLastName(br.readLine());
                String date = br.readLine();
                if (!date.equals("null")) {
                    tempUser.setBirthDate(new Date(Long.parseLong(date)));
                }
                String count = br.readLine();
                if (!count.equals("null")) {
                    tempUser.setCountry(User.Country.valueOf(count));
                }
                String sex = br.readLine();
                if (sex.equals("false")) {
                    tempUser.setMale(false);
                }
                else {
                        tempUser.setMale(false);
                }
                users.add(tempUser);

            }
            br.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
