package com.mrthomas20121.tfc_rocksplus;

import static com.mrthomas20121.tfc_rocksplus.TFC_RocksPlus.MODID;
import static net.dries007.tfc.TerraFirmaCraft.MOD_ID;
import static net.dries007.tfc.types.DefaultRocks.METAMORPHIC;
import static net.dries007.tfc.types.DefaultRocks.SEDIMENTARY;
import static net.dries007.tfc.types.DefaultRocks.IGNEOUS_INTRUSIVE;
import static net.dries007.tfc.types.DefaultRocks.IGNEOUS_EXTRUSIVE;

import net.dries007.tfc.api.registries.TFCRegistryEvent;
import net.dries007.tfc.api.types.Rock;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MODID)
public class DefaultRocks {
    // igneous rocks
    public static final ResourceLocation BLAIMORITE = new ResourceLocation(MOD_ID, "blaimorite");
    public static final ResourceLocation BONINITE = new ResourceLocation(MOD_ID, "boninite");
    public static final ResourceLocation CARBONATITE = new ResourceLocation(MOD_ID, "carbonatite");
    public static final ResourceLocation FOIDOLITE = new ResourceLocation(MOD_ID, "foidolite");

    // sedimentary rocks
    public static final ResourceLocation ARKOSE = new ResourceLocation(MOD_ID, "arkose");
    public static final ResourceLocation JASPILLITE = new ResourceLocation(MOD_ID, "jaspillite");
    public static final ResourceLocation TRAVERTINE = new ResourceLocation(MOD_ID, "travertine");
    public static final ResourceLocation WACKESTONE = new ResourceLocation(MOD_ID, "wackestone");

    // metamorphic rocks
    public static final ResourceLocation BLUESCHIST = new ResourceLocation(MOD_ID, "blueschist");
    public static final ResourceLocation GREENSCHIST = new ResourceLocation(MOD_ID, "greenschist");
    public static final ResourceLocation CATACLASITE = new ResourceLocation(MOD_ID, "cataclasite");
    public static final ResourceLocation MYLONITE = new ResourceLocation(MOD_ID, "mylonite");

    @SubscribeEvent
    public static void onPreRegisterRock(TFCRegistryEvent.RegisterPreBlock<Rock> event)
    {
        event.getRegistry().registerAll(
                new Rock(BLAIMORITE, IGNEOUS_EXTRUSIVE, false),
                new Rock(BONINITE, IGNEOUS_EXTRUSIVE, false),
                new Rock(CARBONATITE, IGNEOUS_EXTRUSIVE, false),
                new Rock(FOIDOLITE, IGNEOUS_INTRUSIVE, false),
                new Rock(ARKOSE, SEDIMENTARY, false),
                new Rock(JASPILLITE, SEDIMENTARY, false),
                new Rock(TRAVERTINE, SEDIMENTARY, false),
                new Rock(WACKESTONE, SEDIMENTARY, false),
                new Rock(BLUESCHIST, METAMORPHIC, false),
                new Rock(GREENSCHIST, METAMORPHIC, false),
                new Rock(CATACLASITE, METAMORPHIC, false),
                new Rock(MYLONITE, METAMORPHIC, false)
        );
    }
}
