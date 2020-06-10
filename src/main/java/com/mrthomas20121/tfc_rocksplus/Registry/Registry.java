package com.mrthomas20121.tfc_rocksplus.Registry;

import net.dries007.tfc.api.recipes.quern.QuernRecipe;
import net.dries007.tfc.api.registries.TFCRegistryEvent;
import net.dries007.tfc.api.types.Ore;
import net.dries007.tfc.objects.Powder;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.objects.items.ItemPowder;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.fml.common.Mod;
import static com.mrthomas20121.tfc_rocksplus.TFC_RocksPlus.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class Registry {

    // ores with no gems
    public static final ResourceLocation mawsonite = new ResourceLocation(MODID, "mawsonite");

    @SubscribeEvent
    public static void onPreRegisterOre(TFCRegistryEvent.RegisterPreBlock<Ore> event)
    {
        IForgeRegistry<Ore> r = event.getRegistry();
        r.register(new Ore(mawsonite));
    }

    @SubscribeEvent
    public static void onRegisterQuernRecipeEvent(RegistryEvent.Register<QuernRecipe> event) {
        IForgeRegistry<QuernRecipe> registry = event.getRegistry();

        registry.registerAll(
                new QuernRecipe(IIngredient.of("gemMawsonite"), new ItemStack(ItemPowder.get(Powder.SULFUR), 6)).setRegistryName("mawsonite_sulfur")
        );
    }

}
