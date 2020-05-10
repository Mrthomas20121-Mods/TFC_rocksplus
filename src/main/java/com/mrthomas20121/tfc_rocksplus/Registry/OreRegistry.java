package com.mrthomas20121.tfc_rocksplus.Registry;

import static com.mrthomas20121.tfc_rocksplus.TFC_RocksPlus.MODID;

import net.dries007.tfc.api.registries.TFCRegistryEvent;
import net.dries007.tfc.api.types.Ore;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = MODID)
public class OreRegistry {
    public static final ResourceLocation mawsonite = new ResourceLocation(MODID, "mawsonite");

    @SubscribeEvent
    public static void onPreRegisterOre(TFCRegistryEvent.RegisterPreBlock<Ore> event)
    {
        IForgeRegistry<Ore> r = event.getRegistry();
        r.register(new Ore(mawsonite));
    }
}
