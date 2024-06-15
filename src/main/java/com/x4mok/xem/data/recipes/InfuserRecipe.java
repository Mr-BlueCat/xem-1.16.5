package com.x4mok.xem.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.x4mok.xem.block.ModBlocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class InfuserRecipe implements IInfuserRecipe{

    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;
    private int amount = 1;

    public InfuserRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }


    @Override
    public boolean matches(IInventory inv, World world) {
        if(!recipeItems.get(0).test(inv.getItem(0))) {
            return false;
        }

        Map<Ingredient, Integer> items = new HashMap<>();

        // WHAT ITEMS ARE REQUIRED?
        Ingredient itemReq1;
        Ingredient itemReq2;
        Ingredient itemReq3;
        Ingredient itemReq4;
        try {
            itemReq1 = recipeItems.get(1);
        } catch (Exception e) {
            itemReq1 = Ingredient.EMPTY;
        }
        try {
            itemReq2 = recipeItems.get(2);
        } catch (Exception e) {
            itemReq2 = Ingredient.EMPTY;
        }
        try {
            itemReq3 = recipeItems.get(3);
        } catch (Exception e) {
            itemReq3 = Ingredient.EMPTY;
        }
        try {
            itemReq4 = recipeItems.get(4);
        } catch (Exception e) {
            itemReq4 = Ingredient.EMPTY;
        }


        // HOW MANY? + // DUPLICATE HANDLING
        items.put(itemReq1, 1);
        if (items.containsKey(itemReq2)) {
            items.put(itemReq2, items.get(itemReq2) + 1);
        } else {
            items.put(itemReq2, 1);
        }
        if (items.containsKey(itemReq3)) {
            items.put(itemReq3, items.get(itemReq4) + 1);
        } else {
            items.put(itemReq3, 1);
        }
        if (items.containsKey(itemReq4)) {
            items.put(itemReq4, items.get(itemReq4) + 1);
        } else {
            items.put(itemReq4, 1);
        }

        // DUPLICATE HANDLING 2
        boolean item1Has = false;
        boolean item2Has = false;
        boolean item3Has = false;
        boolean item4Has = false;

        // DOES ITEM EXIST?
        for (int i = 1; i < 5; i++) {
            if (i == 1) {
                if (itemReq1.test(inv.getItem(1)) && !item1Has) {
                    item1Has = true;
                } else if (itemReq1.test(inv.getItem(2)) && !item2Has) {
                    item2Has = true;
                } else if (itemReq1.test(inv.getItem(3)) && !item3Has) {
                    item3Has = true;
                } else if (itemReq1.test(inv.getItem(4)) && !item4Has) {
                    item4Has = true;
                }
            } else if (i == 2) {
                if (itemReq2.test(inv.getItem(1)) && !item1Has) {
                    item1Has = true;
                } else if (itemReq2.test(inv.getItem(2)) && !item2Has) {
                    item2Has = true;
                } else if (itemReq2.test(inv.getItem(3)) && !item3Has) {
                    item3Has = true;
                } else if (itemReq2.test(inv.getItem(4)) && !item4Has) {
                    item4Has = true;
                }
            } else if (i == 3) {
                if (itemReq3.test(inv.getItem(1)) && !item1Has) {
                    item1Has = true;
                } else if (itemReq3.test(inv.getItem(2)) && !item2Has) {
                    item2Has = true;
                } else if (itemReq3.test(inv.getItem(3)) && !item3Has) {
                    item3Has = true;
                } else if (itemReq3.test(inv.getItem(4)) && !item4Has) {
                    item4Has = true;
                }
            } else {
                if (itemReq4.test(inv.getItem(1)) && !item1Has) {
                    item1Has = true;
                } else if (itemReq4.test(inv.getItem(2)) && !item2Has) {
                    item2Has = true;
                } else if (itemReq4.test(inv.getItem(3)) && !item3Has) {
                    item3Has = true;
                } else if (itemReq4.test(inv.getItem(4)) && !item4Has) {
                    item4Has = true;
                }
            }
        }
        // Result
        return item1Has && item2Has && item3Has && item4Has;
    }

    @Override
    public ItemStack assemble(IInventory inv) {
        return output;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    public int getAmount() {
        return amount;
    }

    public ItemStack getIcon() {
        return new ItemStack(ModBlocks.INFUSER.get());
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.INFUSER_SERIALIZER.get();
    }

    public static class InfuserRecipeType implements IRecipeType<InfuserRecipe> {
        @Override
        public String toString() {
            return InfuserRecipe.TYPE_ID.toString();
        }
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
            implements IRecipeSerializer<InfuserRecipe> {

        @Override
        public InfuserRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "output"));

            JsonArray ingredientsArray = JSONUtils.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(ingredientsArray.size(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                try {
                    inputs.set(i, Ingredient.fromJson(ingredientsArray.get(i)));
                } catch (Exception e) {
                    throw new JsonSyntaxException("Failed to parse ingredient at index " + i, e);
                }
            }

            return new InfuserRecipe(recipeId, output, inputs);
        }

        @Nullable
        @Override
        public InfuserRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buffer.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buffer));
            }

            ItemStack output = buffer.readItem();
            return new InfuserRecipe(recipeId, output, inputs);
        }

        @Override
        public void toNetwork(PacketBuffer buffer, InfuserRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buffer);
            }
            buffer.writeItem(recipe.getResultItem());
        }
    }
}
