package io.github.sskorol.listeners;

import io.github.sskorol.core.DataSupplierInterceptor;
import io.github.sskorol.model.DataSupplierMetaData;
import io.github.sskorol.model.TestNGMethod;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataProviderListener implements DataSupplierInterceptor {

    private static final Map<TestNGMethod, DataSupplierMetaData> META_DATA = new ConcurrentHashMap<>();

    @Override
    public void onDataPreparation(final DataSupplierMetaData testMetaData) {
        META_DATA.putIfAbsent(testMetaData.getTestNGMethod(), testMetaData);
    }

    @Override
    public Collection<DataSupplierMetaData> getMetaData() {
        return META_DATA.values();
    }
}
