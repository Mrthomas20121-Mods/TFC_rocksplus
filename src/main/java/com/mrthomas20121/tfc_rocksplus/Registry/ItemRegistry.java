package com.mrthomas20121.tfc_rocksplus.Registry;

import com.mrthomas20121.tfc_rocksplus.objects.*;

import com.mrthomas20121.tfc_rocksplus.objects.ItemPowder;

import org.apache.commons.lang3.StringUtils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

import static com.mrthomas20121.tfc_rocksplus.TFC_RocksPlus.MODID;
import static net.dries007.tfc.objects.CreativeTabsTFC.*;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = MODID)
public class ItemRegistry {

    public static ArrayList<ItemPowder> powders = new ArrayList<>();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();
        for(Powder powder: Powder.values()) {
            ItemPowder item = register(r, "powder/" + powder.name().toLowerCase(), new ItemPowder(powder), CT_MISC);
            OreDictionary.registerOre("dust"+StringUtils.capitalize(powder.name().toLowerCase()),item);
            powders.add(item);
        }
    }
    private static <T extends Item> T register(IForgeRegistry<Item> r, String name, T item, CreativeTabs ct)
    {
        item.setRegistryName(MODID, name);
        item.setTranslationKey(MODID + "." + name.replace('/', '.'));
        item.setCreativeTab(ct);
        r.register(item);
        return item;
    }
}