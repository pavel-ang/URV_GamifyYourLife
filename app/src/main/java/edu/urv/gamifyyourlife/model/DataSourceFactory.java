package edu.urv.gamifyyourlife.model;

public class DataSourceFactory {
    public static DataSource getDataSource(DataSource.DataSourceType type) {
        if (type == null) {
            return null;
        }

        switch (type) {
            case HARDCODED:
                return  DataSourceHardcoded.getInstance();

            default:
                throw new IllegalArgumentException("Unknown data source type: " + type);
        }
    }
}
