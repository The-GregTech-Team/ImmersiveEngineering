/*
 * BluSunrize
 * Copyright (c) 2017
 *
 * This code is licensed under "Blu's License of Common Sense"
 * Details can be found in the license file in the root folder of this project
 */

package blusunrize.immersiveengineering.client.gui;

import blusunrize.immersiveengineering.client.ClientUtils;
import blusunrize.immersiveengineering.common.blocks.stone.BlastFurnaceTileEntity;
import blusunrize.immersiveengineering.common.gui.BlastFurnaceContainer;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.entity.player.PlayerInventory;

public class BlastFurnaceScreen extends IEContainerScreen
{
	BlastFurnaceTileEntity tile;

	public BlastFurnaceScreen(PlayerInventory inventoryPlayer, BlastFurnaceTileEntity tile)
	{
		super(new BlastFurnaceContainer(inventoryPlayer, tile), inventoryPlayer);
		this.tile = tile;
	}


	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int mx, int my)
	{
		GlStateManager.color3f(1.0F, 1.0F, 1.0F);
		ClientUtils.bindTexture("immersiveengineering:textures/gui/blast_furnace.png");
		this.blit(guiLeft, guiTop, 0, 0, xSize, ySize);

		if(tile.lastBurnTime > 0)
		{
			int h = (int)(12*(tile.burnTime/(float)tile.lastBurnTime));
			this.blit(guiLeft+56, guiTop+37+12-h, 179, 1+12-h, 9, h);
		}
		if(tile.processMax > 0)
		{
			int w = (int)(22*((tile.processMax-tile.process)/(float)tile.processMax));
			this.blit(guiLeft+76, guiTop+35, 177, 14, w, 16);
		}
	}
}