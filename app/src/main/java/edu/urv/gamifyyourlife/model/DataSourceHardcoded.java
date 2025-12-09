package edu.urv.gamifyyourlife.model;

import java.util.ArrayList;
import java.util.List;

public class DataSourceHardcoded extends DataSource {

    private DataSourceHardcoded() {}

    public static synchronized DataSource getInstance() {
        if (instance == null) {
            instance = new DataSourceHardcoded();
        }
        return instance;
    }

    @Override
    public void loadSection(ModSection sec) {
        if (sec.id.equals("1")) {
            sec.objectives = new ArrayList<ModObjective>();
            ModObjective o = new ModObjective("101", "Eat Vegetables", ModObjective.ObjType.YES_NO, 0.0, 0, 0, false);
            sec.objectives.add(o);
            o = new ModObjective("102", "Walk 60 minutes", ModObjective.ObjType.NUMBER, 0.0, 0, 60, false);
            sec.objectives.add(o);
            o = new ModObjective("103", "Drink water", ModObjective.ObjType.YES_NO, 0.0, 0, 0, false);
            sec.objectives.add(o);
        } else if (sec.id.equals("2")) {
            sec.objectives = new ArrayList<ModObjective>();
            ModObjective o = new ModObjective("201", "Finish Project", ModObjective.ObjType.YES_NO, 0.0, 0, 0, false);
            sec.objectives.add(o);
            o = new ModObjective("202", "Answer Emails", ModObjective.ObjType.NUMBER, 0.0, 0, 10, false);
            sec.objectives.add(o);
        } else if (sec.id.equals("3")) {
            sec.objectives = new ArrayList<ModObjective>();
            ModObjective o = new ModObjective("301", "Call Parents", ModObjective.ObjType.YES_NO, 0.0, 0, 0, false);
            sec.objectives.add(o);
            o = new ModObjective("302", "Meet Friends", ModObjective.ObjType.YES_NO, 0.0, 0, 0, false);
            sec.objectives.add(o);
        }
    }

    @Override
    public void loadModel() {
        SECTIONS = new ArrayList<ModSection>();

        ModSection s = new ModSection("1", "Health", 0);
        SECTIONS.add(s);
        loadSection(s);

        s = new ModSection("2", "Work", 0);
        SECTIONS.add(s);
        loadSection(s);

        s = new ModSection("3", "Social Life", 0);
        SECTIONS.add(s);
        loadSection(s);
    }

    @Override
    public List<ModSection> getSections() {
        return SECTIONS;
    }

    @Override
    public ModSection getSection(String section_id) {
        for (ModSection section : SECTIONS) {
            if (section.id.equals(section_id)) {
                return section;
            }
        }
        return null;
    }

    @Override
    public List<ModObjective> getObjectives(String section_id) {
        for (ModSection section : SECTIONS) {
            if (section.id.equals(section_id)) {
                return section.objectives;
            }
        }
        return new ArrayList<ModObjective>();
    }
}