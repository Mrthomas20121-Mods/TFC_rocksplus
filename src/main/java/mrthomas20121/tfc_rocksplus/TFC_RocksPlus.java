package mrthomas20121.tfc_rocksplus;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = TFC_RocksPlus.MODID, name = TFC_RocksPlus.NAME, version = TFC_RocksPlus.VERSION)
public class TFC_RocksPlus
{
    public static final String MODID = "tfc_rocksplus";
    public static final String NAME = "TFC Rocks+";
    public static final String VERSION = "1.3.5";

    private static Logger logger;

    public static Logger getLogger() {
        return logger;
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        VeinLoader.INSTANCE.preInit(event.getModConfigurationDirectory());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
