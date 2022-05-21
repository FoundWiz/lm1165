package net.foundwiz.largemeals.block;

//Blocks
import net.foundwiz.largemeals.block.extended.OmuriceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
//Items
import net.foundwiz.largemeals.item.ModItems;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
//Forge
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
//Mod
import net.foundwiz.largemeals.LargeMeals;

//Java
import java.util.function.Supplier;

public class ModBlocks {
    //Deferred Register
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LargeMeals.MOD_ID);

    //Blocks Registry
    //Feast Block
    public static final RegistryObject<Block> OMURICE_BLOCK = BLOCKS.register("omurice_block",
            () -> new OmuriceBlock(AbstractBlock.Properties.from(vectorwing.farmersdelight.registry.ModBlocks.HONEY_GLAZED_HAM_BLOCK.get()), ModItems.OMURICE, true));

    //Make items from blocks automatically.
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ItemGroup.FOOD)));
    }

    //EventBus
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
