package com.huawei.service;

import com.google.common.base.Preconditions;
import com.huawei.Dao.KlassDao;
import com.huawei.Dao.model.Klass;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlassService {
    @Autowired
    KlassDao klassDao;

    public List<Klass> getAllKlass() {
        return klassDao.getAllKlass();
    }

    public List<Klass> getKlassByName(String name) {
        return klassDao.getKlassByName(name);
    }

    public List<Klass> getKlassById(Long id) {
        return klassDao.getKlassById(id);
    }

    public void save(Klass klass) {
        Preconditions.checkArgument (klass!=null,"klass is null");
        klassDao.insert(klass);
    }

    public void update(Long id, Klass klass) {
        klassDao.updateByPrimaryKey(id, klass);
    }

    public void delete(Long id) {
        klassDao.deleteByPrimaryKey(id);
    }
}
