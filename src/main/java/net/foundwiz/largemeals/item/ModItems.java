package net.foundwiz.largemeals.item;

//Items
import net.foundwiz.largemeals.block.ModBlocks;
import net.minecraft.item.*;
import static vectorwing.farmersdelight.items.Foods.*;
//Effects
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import vectorwing.farmersdelight.items.ConsumableItem;
import vectorwing.farmersdelight.registry.ModEffects;
import net.minecraft.potion.EffectInstance;
//Forge
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.IEventBus;
//Mods
import net.foundwiz.largemeals.LargeMeals;
import vectorwing.farmersdelight.FarmersDelight;

public class ModItems {
    //Deferred Register
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LargeMeals.MOD_ID);

    //Item registries
    //Plated Food
    public static final RegistryObject<Item> COD_DELUXE = ITEMS.register("cod_deluxe",
            () -> new ConsumableItem(new Item.Properties().maxStackSize(16).group(FarmersDelight.ITEM_GROUP).containerItem(Items.BOWL).food(new Food.Builder().hunger(5).saturation(0.7f)
                    .effect(() -> {
                        return new EffectInstance((Effect) ModEffects.NOURISHED.get(), BRIEF_DURATION);
                    }, 1.0F).build() )));
    public static final RegistryObject<Item> COD_SURPRISE = ITEMS.register("cod_surprise",
            () -> new ConsumableItem(new Item.Properties().maxStackSize(16).group(FarmersDelight.ITEM_GROUP).containerItem(Items.BOWL).food(new Food.Builder().hunger(4).saturation(0.9f)
                    .effect(() -> {
                        return new EffectInstance((Effect) ModEffects.NOURISHED.get(), BRIEF_DURATION);
                    }, 1.0F).build() )));
    public static final RegistryObject<Item> HEARTY_LUNCH = ITEMS.register("hearty_lunch",
            () -> new ConsumableItem(new Item.Properties().maxStackSize(16).group(FarmersDelight.ITEM_GROUP).containerItem(Items.BOWL).food(new Food.Builder().hunger(16).saturation(1.7f)
                    .effect(new EffectInstance(Effects.REGENERATION, 60, 0), 1f)
                    .effect(() -> {
                        return new EffectInstance((Effect) ModEffects.COMFORT.get(), LONG_DURATION);
                    }, 1.0F).build() )));
    public static final RegistryObject<Item> MILK_CHICKEN = ITEMS.register("milk_chicken",
            () -> new ConsumableItem(new Item.Properties().maxStackSize(16).group(FarmersDelight.ITEM_GROUP).containerItem(Items.BOWL).food(new Food.Builder().hunger(4).saturation(0.5f)
                    .effect(() -> {
                        return new EffectInstance((Effect) ModEffects.COMFORT.get(), BRIEF_DURATION);
                    }, 1.0F).build() )));
    public static final RegistryObject<Item> MUSHROOM_OMELETTE = ITEMS.register("mushroom_omelette",
            () -> new ConsumableItem(new Item.Properties().maxStackSize(16).group(FarmersDelight.ITEM_GROUP).containerItem(Items.BOWL).food(new Food.Builder().hunger(7).saturation(0.4f)
                    .effect(() -> {
                        return new EffectInstance((Effect) ModEffects.NOURISHED.get(), MEDIUM_DURATION);
                    }, 1.0F).build() )));

    //Bowl Food
    public static final RegistryObject<Item> PUFFERFISH_BROTH = ITEMS.register("pufferfish_broth",
            () -> new ConsumableItem(new Item.Properties().maxStackSize(16).group(FarmersDelight.ITEM_GROUP).containerItem(Items.BOWL).food(new Food.Builder().hunger(5).saturation(0.6f)
                    .effect(new EffectInstance(Effects.NAUSEA, BRIEF_DURATION), 1f)
                    .effect(() -> {
                        return new EffectInstance((Effect) ModEffects.COMFORT.get(), SHORT_DURATION);
                    }, 1.0F).build() )));

    //Feasts
    public static final RegistryObject<Item> OMURICE_BLOCK = ITEMS.register("omurice_block",
            () -> new BlockItem(ModBlocks.OMURICE_BLOCK.get(),
                    new Item.Properties().group(FarmersDelight.ITEM_GROUP)));
    public static final RegistryObject<Item> OMURICE = ITEMS.register("omurice",
            () -> new ConsumableItem(new Item.Properties().maxStackSize(16).group(FarmersDelight.ITEM_GROUP).containerItem(Items.BOWL).food(new Food.Builder().hunger(17).saturation(1.5f)
                    .effect(() -> {
                        return new EffectInstance((Effect) ModEffects.COMFORT.get(), LONG_DURATION);
                    }, 1.0F)
                    .effect(() -> {
                        return new EffectInstance((Effect) ModEffects.NOURISHED.get(), LONG_DURATION);
                    }, 1.0F).build() )));

    //EventBus
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
