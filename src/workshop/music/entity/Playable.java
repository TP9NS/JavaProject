package workshop.music.entity;

public interface Playable {
    //볼륨 설정
    void setVolume(int level);

    //재생 중지
    void stop();
}