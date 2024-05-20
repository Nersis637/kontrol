package com.lab7.entity;
import com.lab7.QuestStatusEnum;
import jakarta.persistence.*;
@Entity
@Table(name="quests")
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questId;
    @Column(name ="questTitle")
    public String questTitle;
    @Column(name ="questText")
    public String questText;
    @Column(name ="personId")
    public String personId;
    @Column(name ="reward")
    public int reward;
    @Column(name ="penalty")
    public int penalty;
    @Column(name ="timeOfStarted")
    public String timeOfStarted;
    @Column(name ="timeForQuestInMinutes")
    public int timeForQuestInMinutes;
    @Column(name ="placeId")
    public String placeId;
    @Column(name ="modelId")
    public String modelId;
    @Column(name ="levelDifficulty")
    public int levelDifficulty;
    @Column(name ="questStatus")
    @Enumerated(EnumType.STRING)
    public QuestStatusEnum questStatus;
    @Column(name ="is_active")
    public boolean is_active;

    public boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Integer getQuestId() {
        return this.questId;
    }

    public void setQuestId(Integer questId) {
        this.questId = questId;
    }

    public String getQuestTitle() {
        return questTitle;
    }

    public void setQuestTitle(String questTitle) {
        this.questTitle = questTitle;
    }

    public String getQuestText() {
        return questText;
    }

    public void setQuestText(String questText) {
        this.questText = questText;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public String getTimeOfStarted() {
        return timeOfStarted;
    }

    public void setTimeOfStarted(String timeOfStarted) {
        this.timeOfStarted = timeOfStarted;
    }

    public int getTimeForQuestInMinutes() {
        return timeForQuestInMinutes;
    }

    public void setTimeForQuestInMinutes(int timeForQuestInMinutes) {
        this.timeForQuestInMinutes = timeForQuestInMinutes;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public int getLevelDifficulty() {
        return levelDifficulty;
    }

    public void setLevelDifficulty(int levelDifficulty) {
        this.levelDifficulty = levelDifficulty;
    }

    public QuestStatusEnum getQuestStatus() {
        return questStatus;
    }

    public void setQuestStatus(QuestStatusEnum questStatus) {
        this.questStatus = questStatus;
    }
}