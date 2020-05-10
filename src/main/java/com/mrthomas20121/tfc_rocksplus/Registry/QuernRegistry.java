package com.mrthomas20121.tfc_rocksplus.Registry;

import net.dries007.tfc.api.recipes.quern.QuernRecipe;

import com.mrthomas20121.tfc_rocksplus.Registry.OreRegistry;
import net.dries007.tfc.api.types.Ore;
import net.dries007.tfc.objects.Powder;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.objects.items.ItemGem;
import net.dries007.tfc.objects.items.ItemPowder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.fml.common.Mod;
import static com.mrthomas20121.tfc_rocksplus.TFC_RocksPlus.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class QuernRegistry {

    @SubscribeEvent
    public static void onRegisterQuernRecipeEvent(RegistryEvent.Register<QuernRecipe> event) {
        IForgeRegistry<QuernRecipe> registry = event.getRegistry();


        registry.registerAll(
                new QuernRecipe(IIngredient.of("gemMawsonite"), new ItemStack(ItemPowder.get(Powder.SULFUR), 3)).setRegistryName("mawsonite_to_sulfur")
        );
    }

}
