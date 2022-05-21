package net.foundwiz.largemeals.block.extended;

//Blocks
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import vectorwing.farmersdelight.blocks.FeastBlock;
//Items
import net.minecraft.item.Item;
//Maths
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
//World
import net.minecraft.world.IBlockReader;

//Java
import java.util.function.Supplier;

public class OmuriceBlock extends FeastBlock {
    //Bounding Box
    protected static final VoxelShape PLATE_SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
    protected static final VoxelShape ROAST_SHAPE;

    //Serving
    public OmuriceBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
    }

    //Shape
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return (Integer)state.get(SERVINGS) == 0 ? PLATE_SHAPE : ROAST_SHAPE;
    }
    static {
        ROAST_SHAPE = VoxelShapes.combine(PLATE_SHAPE, Block.makeCuboidShape(4.0D, 2.0D, 4.0D, 12.0D, 10.0D, 12.0D), IBooleanFunction.OR);
    }
}
