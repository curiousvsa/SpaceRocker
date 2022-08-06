package com.valencio.spacerocker.game.enemy.ship.mapper

import com.valencio.spacerocker.game.enemy.ship.model.Enemy
import com.valencio.spacerocker.game.enemy.ship.model.EnemyUI

class EnemyToEnemyUIMapper {

    operator fun invoke(enemy: Enemy): EnemyUI {
        return with(enemy) {
            EnemyUI(
                enemyId = enemyId,
                width = width,
                height = height,
                xOffset = xOffset,
                yOffset = yOffset,
                hpBarWidth = width / initialHp * hp,
                drawableId = drawableId
            )
        }
    }
}