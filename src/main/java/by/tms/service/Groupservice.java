package by.tms.service;

import by.tms.dao.GroupsDao;
import by.tms.entity.Grades;
import by.tms.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class Groupservice {
    @Autowired
    @Qualifier("hibernateGroupsDao")
    GroupsDao groupsDao;

    @Transactional
    public List<Group> getGroupList(){
        return groupsDao.getList();
    }

    @Transactional
    public Group save(Group group){
        groupsDao.save(group);
        return group;
    }
}
