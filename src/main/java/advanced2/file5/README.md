5. File

5-1. File 클래스
```html
자바에서 파일 또는 디렉토리를 다룰 때는 File 또는 Files, Path 클래스를 사용하면 된다. 이 클래스들을 사용하면 파일이나 폴더를 생성하고 삭제하고 또 정보를 확인할 수 있다.
File 클래스같은 것들은 이런 것들이 있다 정도만 알아두고 필요할때 찾아서 사용하자
```
```java
public class OldFileMain {
    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");
        System.out.println("File exists: " + file.exists());

        boolean created = file.createNewFile();
        System.out.println("File created: " + created);

        boolean dirCreated = directory.mkdir();

        System.out.println("Directory created: " + dirCreated);

        boolean deleted = file.delete();
        System.out.println("File deleted: " + deleted);
        System.out.println("Is file: " + file.isFile());

        System.out.println("Is directory: " + directory.isDirectory());
        System.out.println("File name: " + file.getName());
        System.out.println("File size: " + file.length() + " bytes");
        File newFile = new File("temp/newExample.txt");
        boolean renamed = file.renameTo(newFile);
        System.out.println("File renamed: " + renamed);

        long lastModified = newFile.lastModified();
        System.out.println("Last modified: " + new Date(lastModified));
    }
}
```

5-2. Files 클래스
```html
File 클래스를 대체할 Files 클래스와 Path 클래스가 등장했다.
File과 관련된 스트림의 사용을 고민하기 전에 Files에 있는 기능을 먼저 찾아보자. 성능도 좋고 사용허기도 더 편리하다.
주요 기능만 알아보고 나머지는 필요할 때 검색하자.
```
```java
public class NewFilesMain {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path directory = Path.of("temp/exampleDir");
        // 1. exists(): 파일이나 디렉토리의 존재 여부를 확인
        System.out.println("File exists: " + Files.exists(file));
        // 2. createFile(): 새 파일을 생성
        try {
            Files.createFile(file);
            System.out.println("File created");
        } catch (FileAlreadyExistsException e) {
            System.out.println(file + " File already exists");
        }
        // 3. createDirectory(): 새 디렉토리를 생성
        try {
            Files.createDirectory(directory);
            System.out.println("Directory created");
        } catch (FileAlreadyExistsException e) {
            System.out.

                    println(directory + " Directory already exists");
        }
        // 4. delete(): 파일이나 디렉토리를 삭제
        Files.delete(file);
        System.out.println("File deleted");
        // 5. isRegularFile(): 일반 파일인지 확인
        System.out.println("Is regular file: " + Files.isRegularFile(file));
        // 6. isDirectory(): 디렉토리인지 확인
        System.out.println("Is directory: " + Files.isDirectory(directory));
        // 7. getFileName(): 파일이나 디렉토리의 이름을 반환
        System.out.println("File name: " + file.getFileName());
        // 8. size(): 파일의 크기를 바이트 단위로 반환
        System.out.println("File size: " + Files.size(file) + " bytes");
        // 9. move(): 파일의 이름을 변경하거나 이동
        Path newFile = Paths.get("temp/newExample.txt");
        Files.move(file, newFile, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File moved/renamed");

        // 10. getLastModifiedTime(): 마지막으로 수정된 시간을 반환
        System.out.println("Last modified: " + Files.getLastModifiedTime(newFile));
        // 추가: readAttributes(): 파일의 기본 속성들을 한 번에 읽기
        BasicFileAttributes attrs = Files.readAttributes(newFile, BasicFileAttributes.class);
        System.out.println("===== Attributes =====");
        System.out.println("Creation time: " + attrs.creationTime());
        System.out.println("Is directory: " + attrs.isDirectory());
        System.out.println("Is regular file: " + attrs.isRegularFile());
        System.out.println("Is symbolic link: " + attrs.isSymbolicLink());
        System.out.println("Size: " + attrs.size());
    }
}
```

5-3. 경로 표시
```html
파일이나 디렉토리가 있는 경로는 절대 경로와 상대 경로로 나뉜다.
절대 경로는 경로의 처음부터 내가 입력한 모든 경로를 다 표현한다
정규 경로는 경로의 계산이 모두 끝난 경로이다. 하나만 존재한다.
```

5-4. Files로 문자 파일 읽기
```html
Files는 스트림 클래스를 추가해서 파일을 읽어야하는 불편함과 반목문을 사용하는 점을 해결해준다.
```
```java
public class ReadTextFileV1 {

    private static final String PATH = "src/main/java/advanced2/file5/temp/hello.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다"; System.out.println("== Write String =="); System.out.println(writeString);
        Path path = Path.of(PATH);

        Files.writeString(path, writeString, StandardCharsets.UTF_8);

        String readString = Files.readString(path, StandardCharsets.UTF_8);

        System.out.println("== Read String ==");
        System.out.println(readString);
    }
}
```

5-5. 파일 복사
```html
파일을 복사할 때는 Files 클래스의 copy() 메서드를 사용하면 된다.
Files.copy()는 자바에 파일 데이터를 불러오지 않고 운영체제의 파일 복사 기능을 사용한다.
이 기능은 파일에서 파일을 복사할 때만 유용하다. 파일의 정보를 처리해야하거나 스트림을 통해 네트워크로 전달해야 한다면 스트림을 직접 사용해야 한다.
스트림을 사용할떄는 transferTo()를 사용하자
```
```java
public class FileCopyMainV2 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/advanced2/file5/temp/hello.txt");
        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"/src/main/java/advanced2/file5/temp/hello2.txt");
        fis.transferTo(fos);
        fis.close();
        fos.close();
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + "ms");
    }
}
```
```java
public class FileCopyMainV3 {
    public static void main(String[] args) throws IOException {
          long startTime = System.currentTimeMillis();
          Path source = Path.of("temp/copy.dat");
          Path target = Path.of("temp/copy_new.dat");
          Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
          long endTime = System.currentTimeMillis();
          System.out.println("Time taken: " + (endTime - startTime) + "ms");
      }
}
```