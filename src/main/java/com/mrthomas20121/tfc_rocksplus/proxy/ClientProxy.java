package com.mrthomas20121.tfc_rocksplus.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.mrthomas20121.tfc_rocksplus.Registry.ItemRegistry;
import com.mrthomas20121.tfc_rocksplus.objects.ItemPowder;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void postInit(FMLPostInitializationEvent e) {
		
    }
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        for(ItemPowder item: ItemRegistry.powders) {
            ModelLoader.setCustomModelResourceLocation(item, 0 , new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }
}
