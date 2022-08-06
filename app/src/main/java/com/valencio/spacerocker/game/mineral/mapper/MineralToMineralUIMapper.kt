package com.valencio.spacerocker.game.mineral.mapper

import com.valencio.spacerocker.game.mineral.model.Mineral
import com.valencio.spacerocker.game.mineral.model.MineralUI

class MineralToMineralUIMapper {

    operator fun invoke(mineral: Mineral): MineralUI {
        return with(mineral) {
            MineralUI(
                xOffset = xOffset,
                yOffset = yOffset,
                width = width,
                alpha = alpha
            )
        }
    }
}