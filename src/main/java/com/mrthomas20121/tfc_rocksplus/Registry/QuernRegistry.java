package com.mrthomas20121.tfc_rocksplus.Registry;

import net.dries007.tfc.api.recipes.quern.QuernRecipe;

import net.dries007.tfc.objects.Powder;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.objects.items.ItemPowder;
import net.minecraft.item.ItemStack;
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
                new QuernRecipe(IIngredient.of("gemMawsonite"), new ItemStack(ItemPowder.get(Powder.SULFUR), 3)).setRegistryName("mawsonite_sulfur"),
                new QuernRecipe(IIngredient.of("gemPitchblende"), new ItemStack(com.mrthomas20121.tfc_rocksplus.objects.ItemPowder.get(com.mrthomas20121.tfc_rocksplus.objects.Powder.URANIUM), 6)).setRegistryName("uranium_dust"),
                new QuernRecipe(IIngredient.of("gemOlivine"), new ItemStack(com.mrthomas20121.tfc_rocksplus.objects.ItemPowder.get(com.mrthomas20121.tfc_rocksplus.objects.Powder.MANGANESE), 6)).setRegistryName("manganise_dust")
        );
    }

}
