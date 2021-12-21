import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HangarCollection {
    private final Map<String, Hangar<Plane, IMissilesForm>> hangarStages;
    private final int frameWidth;
    private final int frameHeight;

    public HangarCollection(int frameWidth, int frameHeight) {
        hangarStages = new HashMap<>();
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    public void AddHangar(String name) {
        if (!hangarStages.containsKey(name)) {
            hangarStages.put(name, new Hangar<>(frameWidth, frameHeight));
        }
    }

    public void DelHangar(String name) {
        hangarStages.remove(name);
    }

    public Hangar<Plane, IMissilesForm> get(String name) {
        if (hangarStages.containsKey(name)) {
            return hangarStages.get(name);
        }
        return null;
    }

    public Plane getAir(String hangarName, int planeIndex) {
        if (hangarStages.containsKey(hangarName)) {
            return hangarStages.get(hangarName).getPlane(planeIndex);
        }
        return null;
    }

    public Set<String> keySet() {
        return hangarStages.keySet();
    }
}
