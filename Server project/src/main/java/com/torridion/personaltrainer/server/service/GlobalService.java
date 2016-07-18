package com.torridion.personaltrainer.server.service;

import com.torridion.personaltrainer.server.entity.Global;

public interface GlobalService {
    Global getStatistic();
    void updateStatistic(Global global);
}
