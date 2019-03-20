package modulardiversity.util;

import hellfirepvp.modularmachinery.common.crafting.helper.ComponentRequirement;
import hellfirepvp.modularmachinery.common.crafting.helper.RecipeCraftingContext;
import hellfirepvp.modularmachinery.common.machine.MachineComponent;
import hellfirepvp.modularmachinery.common.machine.MachineComponent.IOType;
import hellfirepvp.modularmachinery.common.modifier.RecipeModifier;
import hellfirepvp.modularmachinery.common.util.IOInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.util.Collection;

public class Misc {
    public static TileEntity getTileEntity(MachineComponent component)
    {
        Object provider = component.getContainerProvider();
        if(provider instanceof FluidTank)
            ReflectionHelper.getPrivateValue(FluidTank.class,(FluidTank)provider,"tile");
        if(provider instanceof IOInventory)
            return ((IOInventory) provider).getOwner();
        if(provider instanceof TileEntity)
            return (TileEntity) provider;
        return null;
    }

    public static int applyModifiers(RecipeCraftingContext context, String target, IOType ioType, int value, boolean isChance) {
        return (int)RecipeModifier.applyModifiers(context.getModifiers(target),target,ioType,value,isChance);
    }

    public static long applyModifiers(RecipeCraftingContext context, String target, IOType ioType, long value, boolean isChance) {
        return (long)RecipeModifier.applyModifiers(context.getModifiers(target),target,ioType,value,isChance);
    }

    public static float applyModifiers(RecipeCraftingContext context, String target, IOType ioType, float value, boolean isChance) {
        return RecipeModifier.applyModifiers(context.getModifiers(target),target,ioType,value,isChance);
    }

    public static double applyModifiers(RecipeCraftingContext context, String target, IOType ioType, double value, boolean isChance) {
        return RecipeModifier.applyModifiers(context.getModifiers(target),target,ioType,(float)value,isChance);
    }

    public static int applyModifiers(Collection<RecipeModifier> context, String target, IOType ioType, int value, boolean isChance) {
        return (int)RecipeModifier.applyModifiers(context,target,ioType,value,isChance);
    }

    public static long applyModifiers(Collection<RecipeModifier> context, String target, IOType ioType, long value, boolean isChance) {
        return (long)RecipeModifier.applyModifiers(context,target,ioType,value,isChance);
    }

    public static float applyModifiers(Collection<RecipeModifier> context, String target, IOType ioType, float value, boolean isChance) {
        return RecipeModifier.applyModifiers(context,target,ioType,value,isChance);
    }

    public static double applyModifiers(Collection<RecipeModifier> context, String target, IOType ioType, double value, boolean isChance) {
        return RecipeModifier.applyModifiers(context,target,ioType,(float)value,isChance);
    }
}