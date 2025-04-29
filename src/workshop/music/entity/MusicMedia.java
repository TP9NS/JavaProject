package workshop.music.entity;

public abstract class MusicMedia {
    protected String title; //제목
    protected String artist; //아티스트

    public MusicMedia(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    
    public abstract void play();

    //공통 정보 출력
    public void displayInfo() {
        System.out.println("제목: " + title + ", 아티스트: " + artist);
    }
}