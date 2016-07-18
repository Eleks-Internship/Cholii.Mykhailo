package com.torridion.personaltrainer.server.service;

import com.torridion.personaltrainer.server.entity.Subscribes;

public interface SubscribesService {
    Subscribes subscribe(Subscribes subscribe);
    boolean unsubscribe(Subscribes subscribes);
}
