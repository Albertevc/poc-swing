package br.com.aevc.pocswing.view.component;

import java.util.List;

public interface JTableModelUpdater<T> {

    void updateTableModel(List<T> modelList);
}
