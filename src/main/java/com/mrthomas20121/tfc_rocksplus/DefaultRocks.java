package com.mrthomas20121.tfc_rocksplus;

import static com.mrthomas20121.tfc_rocksplus.TFC_RocksPlus.MODID;
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
    public static final ResourceLocation BLAIMORITE = new ResourceLocation(MODID, "blaimorite");
    public static final ResourceLocation BONINITE = new ResourceLocation(MODID, "boninite");
    public static final ResourceLocation CARBONATITE = new ResourceLocation(MODID, "carbonatite");
    public static final ResourceLocation FOIDOLITE = new ResourceLocation(MODID, "foidolite");

    // sedimentary rocks
    public static final ResourceLocation ARKOSE = new ResourceLocation(MODID, "arkose");
    public static final ResourceLocation JASPILLITE = new ResourceLocation(MODID, "jaspillite");
    public static final ResourceLocation TRAVERTINE = new ResourceLocation(MODID, "travertine");
    public static final ResourceLocation WACKESTONE = new ResourceLocation(MODID, "wackestone");

    // metamorphic rocks
    public static final ResourceLocation BLUESCHIST = new ResourceLocation(MODID, "blueschist");
    public static final ResourceLocation GREENSCHIST = new ResourceLocation(MODID, "greenschist");
    public static final ResourceLocation CATACLASITE = new ResourceLocation(MODID, "cataclasite");
    public static final ResourceLocation MYLONITE = new ResourceLocation(MODID, "mylonite");


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
