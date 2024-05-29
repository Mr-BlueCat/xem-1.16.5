package com.x4mok.xem.events;

import com.x4mok.xem.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.IRandomRange;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.ThreadLocalRandom;

@Mod.EventBusSubscriber(modid = "xem")
public class DragonDrops {

    private static final ResourceLocation ENDER_DRAGON_LOOT_TABLE = new ResourceLocation("xem", "entities/ender_dragon");
    private static final ResourceLocation VANILLA_ENDER_DRAGON_LOOT_TABLE = new ResourceLocation("minecraft", "entities/ender_dragon");

//    @SubscribeEvent
//    public static void onLootTableLoad(LootTableLoadEvent event) {
//        if (event.getName().equals(VANILLA_ENDER_DRAGON_LOOT_TABLE)) {
//            LootPool pool = LootPool.lootPool().add(TableLootEntry.lootTableReference(ENDER_DRAGON_LOOT_TABLE)).build();
//            event.getTable().addPool(pool);
//        }
//    }

    public static void sendPlayerMessage(PlayerEntity player, String message) {
        // Create a text component from the message string
        StringTextComponent textComponent = new StringTextComponent(TextFormatting.GREEN + message);

        // Send the message to the player
        player.sendMessage(textComponent, player.getUUID());
    }

    public static void dropItemInWorld(World world, PlayerEntity player, ItemStack itemStack) {
        if (!world.isClientSide) { // Ensure you're on the server side
            ItemEntity itemEntity = new ItemEntity(world, player.position().x, player.position().y, player.position().z, itemStack);
            world.addFreshEntity(itemEntity);
        }
    }

    @SubscribeEvent
    public static void onEnderDragonDeath(LivingDeathEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof EnderDragonEntity) {
            EnderDragonEntity enderDragon = (EnderDragonEntity) entity;
            PlayerEntity player = (PlayerEntity) enderDragon.getCombatTracker().getKiller();
            if (player != null) {
                // Give custom items to the player who dealt the final blow
                ItemStack dragonscale = new ItemStack(ModItems.DRAGONSCALE.get());
                ItemStack dragonblood = new ItemStack(ModItems.DRAGONBLOOD.get());

                System.out.println("got itemstacks");

                int randomInt = ThreadLocalRandom.current().nextInt(3, 9 + 1);

                for (int i = 1; i <= randomInt; i++) {
                    System.out.println("Iteration " + i);
                    DragonDrops.dropItemInWorld(player.getEntity().level, player, new ItemStack(ModItems.DRAGONSCALE.get()));
                    System.out.println("DROPPED");
                }

                randomInt = ThreadLocalRandom.current().nextInt(3, 9 + 1);

                for (int i = 1; i <= randomInt; i++) {
                    System.out.println("Iteration " + i);
                    DragonDrops.dropItemInWorld(player.getEntity().level, player, new ItemStack(ModItems.DRAGONBLOOD.get()));
                    System.out.println("DROPPED");
                }

                sendPlayerMessage(player, "A Dragon's Blood Dropped Near You!");
                sendPlayerMessage(player, "A Dragon's Scale Dropped Near You!");

/*
                double randomNumber = Math.random();

                // Scale the random number to the range [1, 3]
                double scaledRandomNumber = 1 + randomNumber * (3 - 1);

                // Convert to integer if needed
                int randomInt = (int) scaledRandomNumber;



                if (!player.inventory.add(randomInt, dragonscale)) {
                    System.out.println("dropped");
                    sendPlayerMessage(player, "A Dragon's Scale Dropped Near You!");
                    DragonDrops.dropItemInWorld(player.getEntity().level, player, new ItemStack(ModItems.DRAGONSCALE.get()));

                }else {
                    System.out.println("no drop");
                    sendPlayerMessage(player, "A Dragon's Scale Dropped Near You!");
                    DragonDrops.dropItemInWorld(player.getEntity().level, player, new ItemStack(ModItems.DRAGONSCALE.get()));
                }
                randomNumber = Math.random();

                // Scale the random number to the range [1, 3]
                scaledRandomNumber = 1 + randomNumber * (3 - 1);

                // Convert to integer if needed
                randomInt = (int) scaledRandomNumber;

                if (!player.inventory.add(randomInt ,dragonblood)) {
                    System.out.println("dropped");
                    sendPlayerMessage(player, "A Dragon's Blood Dropped Near You!");
                    DragonDrops.dropItemInWorld(player.getEntity().level, player, new ItemStack(ModItems.DRAGONBLOOD.get()));
                }else {
                    System.out.println("no drop");
                    sendPlayerMessage(player, "A Dragon's Blood Dropped Near You!");
                    DragonDrops.dropItemInWorld(player.getEntity().level, player, new ItemStack(ModItems.DRAGONBLOOD.get()));
                }
                */
            }
        }
    }
}