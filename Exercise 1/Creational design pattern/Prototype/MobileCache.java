package Prototype;

import java.util.Hashtable;

class MobileCache {
    private static Hashtable<String, Mobile> MobileMap = new Hashtable<String,
            Mobile>();

    public static Mobile getMobile(String MobileId) {
        Mobile cachedMobile = MobileMap.get(MobileId);
        return (Mobile) cachedMobile.clone();
    }

    public static void loadCache() {
        Oppo Oppo = new Oppo();
        Oppo.setId("1");
        MobileMap.put(Oppo.getId(), Oppo);
        Vivo Vivo = new Vivo();
        Vivo.setId("2");
        MobileMap.put(Vivo.getId(), Vivo);
        iPhone iPhone = new iPhone();
        iPhone.setId("3");
        MobileMap.put(iPhone.getId(), iPhone);
    }

}
