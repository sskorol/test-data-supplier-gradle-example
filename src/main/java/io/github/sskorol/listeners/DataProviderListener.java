package io.github.sskorol.listeners;

import io.github.sskorol.core.DataSupplierInterceptor;
import io.github.sskorol.model.DataSupplierMetaData;
import org.testng.ITestNGMethod;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataProviderListener implements DataSupplierInterceptor {

    private static final Map<ITestNGMethod, DataSupplierMetaData> META_DATA = new ConcurrentHashMap<>();

    @Override
    public void onDataPreparation(final DataSupplierMetaData testMetaData) {
        META_DATA.putIfAbsent(testMetaData.getTestMethod(), testMetaData);
    }

    @Override
    public Collection<DataSupplierMetaData> getMetaData() {
        return META_DATA.values();
    }
}
