package com.mrthomas20121.tfc_rocksplus.objects;

import java.util.EnumMap;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.dries007.tfc.api.capability.size.Size;
import net.dries007.tfc.api.capability.size.Weight;
import net.dries007.tfc.objects.items.ItemTFC;

@SuppressWarnings("WeakerAccess")
@ParametersAreNonnullByDefault
public class ItemPowder extends ItemTFC
{
    private static final EnumMap<Powder, ItemPowder> MAP = new EnumMap<>(Powder.class);

    public static ItemPowder get(Powder powder)
    {
        return MAP.get(powder);
    }

    public static ItemStack get(Powder powder, int amount)
    {
        return new ItemStack(MAP.get(powder), amount);
    }

    private final Powder powder;

    public ItemPowder(Powder powder)
    {
        this.powder = powder;
        if (MAP.put(powder, this) != null) throw new IllegalStateException("There can only be one.");
        setMaxDamage(0);
    }

    @Nonnull
    @Override
    public Size getSize(ItemStack stack)
    {
        return Size.SMALL; // Stored everywhere
    }

    @Nonnull
    @Override
    public Weight getWeight(ItemStack stack)
    {
        return Weight.VERY_LIGHT; // Stacksize = 64
    }

    @Nonnull
    public Powder getPowder()
    {
        return powder;
    }
}