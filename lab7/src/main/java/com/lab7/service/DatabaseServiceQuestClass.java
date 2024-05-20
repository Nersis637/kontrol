package com.lab7.service;


import com.lab7.entity.Quest;
import com.lab7.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DatabaseServiceQuestClass implements DatabaseServiceKR<Quest> {
    @Autowired
    QuestRepository questRepository;

    @Override
    public List<Quest> getList() {
        List<Quest> listQuest = new ArrayList<>();
        for (Quest quest : questRepository.findAll())
            if(quest.getIs_active()){
                listQuest.add(quest);
            }
        return listQuest;
    }

    @Override
    public Quest get(int id) {
        if(questRepository.findById(id).isPresent())
            return questRepository.findById(id).get();
        else return null;
    }

    @Override
    public void create(Quest tmp) {
        questRepository.save(tmp);
    }

    @Override
    public void update(Quest tmp) {
        tmp.setIs_active(true);
        questRepository.save(tmp);
    }

    @Override
    public void delete(int id) {
        Quest quest=get(id);
        quest.setIs_active(false);
        questRepository.save(quest);
    }

}
