package io.github.fatimazza.footballclub.home

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.textView

class TeamsFragment: Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return createView(AnkoContext.create(ctx))
    }

    fun createView(ui: AnkoContext<Context>): View = with(ui) {
        linearLayout{
            textView {
                text = "Teams Fragment"
            }
        }
    }
}